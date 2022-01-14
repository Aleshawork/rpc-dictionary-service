pipeline {
  agent any

   environment {
      IMAGE_BASE = 'aleshawork/docker-test-service'
      IMAGE_TAG = "v$BUILD_NUMBER"
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


      stage('Push images') {
            agent any
            when {
              branch 'develope'
            }
            steps {
              script {
                def dockerImage = docker.build("${env.IMAGE_NAME}", "-f ${env.DOCKERFILE_NAME} .")
                docker.withRegistry('', 'dockerhub-creds') {
                  dockerImage.push()
                  dockerImage.push("latest")
                }
                echo "Pushed Docker Image: ${env.IMAGE_NAME}"
              }
              sh "docker rmi ${env.IMAGE_NAME} ${env.IMAGE_NAME_LATEST}"
            }
      }
  }

 }