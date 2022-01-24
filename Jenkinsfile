pipeline
{
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
                    }
               }

              stage("Push image") {
              when {
                branch "develope"
              }
                steps{
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable:'dockerHubPassword', usernameVariable:'dockerHubUser')]){
                        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                        sh 'docker push aleshawork/docker-test-service:latest'
                    }
                }
              }
      }

 }