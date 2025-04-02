pipeline {
    agent any
    tools {
        jdk 'JDK 17'
        maven 'Maven 3'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/Sowmiya-Saravanan/Jenkins']])
                bat 'mvn clean install'
            }
        }
    }
    post {
        success {
            script {
                emailext(
                    subject: "Build SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Build was successful!\nView details: ${env.BUILD_URL}",
                    to: "2k21csbs48@kiot.ac.in,2k21csbs38@kiot.ac.in,2k21csbs11@kiot.ac.in,ssowmiyasaravananr@gmail.com"
                )
            }
        }
        failure {
            script {
                emailext(
                    subject: "Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: "Build failed!\nCheck logs: ${env.BUILD_URL}",
                    to: "2k21csbs48@kiot.ac.in,2k21csbs38@kiot.ac.in,2k21csbs11@kiot.ac.in,ssowmiyasaravananr@gmail.com"
                )
            }
        }
    }
}
