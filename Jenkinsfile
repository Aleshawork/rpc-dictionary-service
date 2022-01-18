pipeline {
  agent any

   environment{
      IMAGE_BASE = 'aleshawork/docker-test-service'
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
         sh 'docker build -t aleshawork/docker-test-service:latest .'
//            script {
//                 sh 'docker build -t shanem/spring-petclinic:latest .'
//                //myapp = docker.build("${IMAGE_BASE}")
//              }
        }

       }
      stage("Push image") {
      steps {
          script {
              docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-creds') {
                      myapp.push("${env.BUILD_NUMBER}")
              }
          }
      }
      }
  }

 }