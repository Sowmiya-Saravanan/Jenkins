pipeline {
    agent any
    tools {
        jdk 'JDK 17'
        maven 'Maven 3'
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
                    bat 'docker build -t sowmiya11/sowmiya .'
                }
            }
        }

        stage('Push Image to DockerHub') {
            steps {
                script {

                    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USER')]) {
                    bat 'docker login -u %DOCKER_USER% -p %DOCKER_PASSWORD%'
                    bat 'docker push sowmiya11/sowmiya'
}
    // some block
                }
            }
        }
    }
}
