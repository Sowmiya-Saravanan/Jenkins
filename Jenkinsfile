pipeline{
    agent any
        tools{
            jdk 'JDK 17'
            maven 'Maven 3'
        }
        stages{
            stage('Build Maven'){
                steps{
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Sowmiya-Saravanan/Jenkins]])
                    bat 'mvn clean install'
                }
            }
           
        }
}