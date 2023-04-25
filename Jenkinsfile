pipeline {
    agent any

    stages {
        stage('Stop running on port 8080') {
            steps {
                sh 'sudo lsof -t -i:8080 | xargs --no-run-if-empty sudo kill -9'
            }
        }

        stage('git repo & clean') {
            steps {
               sh "rm -rf  /s /q clickup"
                sh "git clone https://github.com/Hasish97/clickup.git"
                sh "mvn clean -f clickup"
            }
        }
        stage('install & build') {
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
        stage('Deploy and Run') {
            steps {
              
                sh "./startclickup.sh"
                
            }
        
        }

    }
}
