pipeline {
  environment {
    dockerimagename = "huu2412002/soa-backend"
    dockerImage = ""
  }
  agent any
  stages {
    stage('Checkout Source') {
      steps {
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
    stage('Deploying soa-backend container to Kubernetes') {
      steps {
        script {
          kubernetesDeploy(configs: "pod.yaml", "hpa.yaml","service.yaml")
        }
      }
    }
  }
}