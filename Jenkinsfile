pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
		sh "mvn clean package"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		sshagent(['ubuntu_user']) {
   		sh "scp -o StrictHostKeyChecking=no target/Devops-1.0-SNAPSHOT.war ubuntu@172.31.84.235:8065:/opt/apache-tomcat-8.5.60/webapps"
}
            }
        }
    }
}