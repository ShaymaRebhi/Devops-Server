
pipeline {
	agent any 
	stages{
		stage('Chockout Git0'){
            steps{
                echo 'Pulling...';
                git branch: 'main',
                url :'https://github.com/ShaymaRebhi/tpAchatProject-Server.git';
            }			
        }
    }
}
