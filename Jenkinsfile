pipeline {
    agent any

    environment {
    YOUR_DEPLOY_SERVER = "192.168.109.134"
    PATH_TO_DEPLOY = "/home/clickup/backend"
  }

    stages {
        stage('git repo & clean') {
            steps {
               sh "rm -rf  /s /q clickup"
                sh "git clone https://github.com/Hasish97/clickup.git"
                sh "mvn clean -f clickup"
            }
        }
        stage('install') {
            steps {
                sh "mvn clean install -f clickup"
            }
        }
        stage('test') {
            steps {
                sh "mvn test -f clickup"
            }
        }
        stage('package') {
            steps {
                sh "mvn package -f clickup"
            }
        }
        stage('Deploy') {
            steps {
                sshagent(["4add3352-6b40-476c-b1be-2d6e394d4cd5"]) {
                sh "cp clickup/target/ClickupDashboard-0.0.1-SNAPSHOT.jar 192.168.109.134:/home/clickup/backend"
                sh "ssh clickup@192.168.109.134 'java -jar /home/clickup/backend/ClickupDashboard-0.0.1-SNAPSHOT.jar &'"
            }
            }
        }

    }
}
