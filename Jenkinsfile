pipeline {
  environment {
    dockerimagename = "huu2412002/soa-backend:v01"
    dockerImage = ""
  }
  agent any
  stages {
    stage('Checkout Source') {
      steps {
        cleanWs()
        git 'https://github.com/vantohuu/SOA-Backend.git'
      }
    }
    stage('Build image') {
      steps{
        script {
          dockerImage = docker.build dockerimagename
        }
      }
    }
    stage('Deploying React.js container to Kubernetes') {
          steps {
            script {
              bat 'kubectl get pods'
            }
          }
        }

  }
}
