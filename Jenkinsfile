pipeline {
    agent any
    tools {
        jdk 'JDK 17'
        maven 'Maven 3'
    }
    }
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
            bat 'docker login'
            bat 'docker push sowmiya11/sowmiya'
        }
    }
}
