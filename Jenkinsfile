pipeline{
agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }

        stages{


             stage('MVN CLEAN')
                        {
                            steps{
                            sh  'mvn clean  '
                            }
                        }
                        stage('MVN COMPILE ')
                        {
                            steps{
                            sh  'mvn compile  '
                            }
                        }
                        stage('MVN PACKAGE'){
                                      steps{
                                          sh  'mvn package  '
                                      }
                                }
			stage("Maven Build") {
             steps {
                script {
                   sh "mvn package "
                 }
             }
         }

                                       stage('MVN Test'){
                                                          steps{
                                                              sh  'mvn test'

                                                    }
                                       }
	
                                         stage('MVN SONARQUBE ')
                                                        {
                                                            steps{
                                                            sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  -DskipTests=true'
                                                            }
                                                        }
                                       //  stage("nexus deploy"){
                                         //          steps{
                                           //          sh 'mvn  deploy  -DskipTests=true'
                                             //                        }
                                               //                   }
			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t oumaymafarhani/devops .'
                                 }
                             }
                         }



 		
		 		 stage('Docker login') {

                                         steps {
                                          sh 'echo "login Docker ...."'
                   	sh 'docker login -u oumaymafarhani -p 29416927Oumayma'
                               }  }
		 stage('Docker push') {

                 steps {
                      sh 'echo "Docker is pushing ...."'
                     	sh 'docker push oumaymafarhani/devops'
                        }  }
         stage('Docker compose') {

                          steps {
                               sh 'docker-compose up -d'
                                 }  }



//               stage('Quality Gate Status Check'){
//                   steps{
//                       script{
// 			      withSonarQubeEnv('sonar') {
// 			      sh "mvn compile sonar:sonar"
//                        	     	}
// 			      timeout(time: 1, unit: 'HOURS') {
// 			      def qg = waitForQualityGate()
// 				      if (qg.status != 'OK') {
// 					   error "Pipeline aborted due to quality gate failure: ${qg.status}"
// 				      }
//                     		}
// 		    	    sh "mvn clean install"
//                  	}
//                	 }
              }
      }
