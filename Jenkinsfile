pipeline{
    agent any
        tools{
            jdk 'JDK 17'
            maven 'Maven 3'
        }
        stages{
            stage('Build Maven'){
                steps{
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/AjushaLalasan/contactmanager_jenkins&#39;]])
                    bat 'mvn clean install'
                }
            }
           
        }
}