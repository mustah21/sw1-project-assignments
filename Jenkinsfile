pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'Github', url: 'https://github.com/mustah21/sw1-project-assignments', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                dir('week4-inclass') {
                    bat 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                dir('week4-inclass') {
                    bat 'mvn test'
                }
            }
        }
        stage('Code Coverage') {
            steps {
                dir('week4-inclass') {
                    bat 'mvn jacoco:report'
                }
            }
        }
        stage('Publish Test Results') {
            steps {
                junit 'week4-inclass/**/target/surefire-reports/*.xml'
            }
        }
    }
}