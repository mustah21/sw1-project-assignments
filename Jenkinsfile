pipeline {
    agent any
    tools {
        maven 'maven'
    }

    environment {
        PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;"
        DOCKERHUB_CREDENTIALS_ID = 'docker-hub'
        DOCKERHUB_REPO = 'mustah21/week6-speed'
        DOCKER_IMAGE_TAG = 'v1'
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


        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }








    }
}