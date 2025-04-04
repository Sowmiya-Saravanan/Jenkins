pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'sowmiya11/sowmiya'
        K8S_DEPLOYMENT_NAME = 'myapp-deployment'
        K8S_NAMESPACE = 'default'
    }
    stages {
        stage('Build Maven') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Use Groovy variable interpolation with double quotes
                    bat "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Push Image to DockerHub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USER')]) {
                        bat "docker login -u ${DOCKER_USER} -p ${DOCKER_PASSWORD}"
                        bat "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    withCredentials([file(credentialsId: 'KUBE_CONFIG', variable: 'KUBE_CONFIG')]) {
                // Set the KUBECONFIG environment variable for kubectl to use
                env.KUBECONFIG = KUBE_CONFIG
                
                // Apply the Kubernetes deployment YAML file
                bat "kubectl apply -f myapp-deployment.yaml"
                
                // Restart deployment to use the latest Docker image
                bat "kubectl set image deployment/myapp-deployment myapp-container=${DOCKER_IMAGE}:latest -n ${K8S_NAMESPACE}"
             }
                }
            }
        }
    }
}
