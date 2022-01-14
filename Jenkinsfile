pipeline {
  agent any

  stages {
      stage('Maven Build') {
          steps {
              sh 'mvn clean install'
          }
        }
      stage('Stage 2') {
          steps {
            script {
              echo 'Stage 2'
            }
          }
        }
      }
}