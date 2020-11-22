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
		sshagent(['deploy_user1']) {
   		sh "scp -o StrictHostKeyChecking=no webapp/target/Devops-1.0-SNAPSHOT.war ec2-user@18.233.225.48:8080:/opt/apache-tomcat-8.5.60/webapps"
}
            }
        }
    }
}