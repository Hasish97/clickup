pipeline {
    agent any

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
              
                sh "nohup java -jar /var/lib/jenkins/workspace/clickupp/clickup/target/ClickupDashboard-0.0.1-SNAPSHOT.jar"
                
            }
            
        }

    }
}
