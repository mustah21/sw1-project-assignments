pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'Github', url: 'https://github.com/mustah21/sw1-project-assignments', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                dir('week6-speed') {
                    bat 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                dir('week6-speed') {
                    bat 'mvn test'
                }
            }
        }
        stage('Code Coverage') {
            steps {
                dir('week6-speed') {
                    bat 'mvn jacoco:report'
                }
            }
        }
        stage('Publish Test Results') {
            steps {
                junit 'week6-speed/**/target/surefire-reports/*.xml'
            }
        }
    }
}