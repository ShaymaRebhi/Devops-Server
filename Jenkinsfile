pipeline {
    agent any
    tools {
    	maven 'M2_HOME'
    }
    stages {
       
        stage('Checkout GIT ') {
            steps {
                echo 'Pulliing ...';
                git branch: 'ons', url: 'https://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@github.com/ShaymaRebhi/tpAchatProject-Server.git'            }

        }
	    
	    stage('compiler') {
      		steps {
        		sh 'mvn compile'
      		}
    	}
	    stage('Build') {
      		steps {
        		sh 'mvn -B -DskipTests clean package'
      		}
    	}
	    
        stage('Testing maven') {
		    steps {
		    sh """mvn -version"""
	        }
	    }