pipeline {
  agent any

   environment{
      IMAGE_BASE = 'aleshawork/docker-test-service'
      IMAGE_TAG = "v${BUILD_NUMBER}"
      IMAGE_NAME = "${env.IMAGE_BASE}:${env.IMAGE_TAG}"
      IMAGE_NAME_LATEST = "${env.IMAGE_BASE}:latest"
      DOCKERFILE_NAME = "Dockerfile"
    }

  stages {
      stage('Maven Build') {
      steps{
              withMaven{
                sh "mvn clean install"
              }
          }
        }


      stage("Build image") {
      steps {
          script {
              myapp = docker.build("my-image")
          }
      }
  }
      stage("Push image") {
      steps {
          script {
              docker.withRegistry('https://hub.docker.com/repository/docker/aleshawork/docker-test-service', 'dockerhub-creds') {
                      myapp.push()
              }
          }
      }
      }
  }

 }