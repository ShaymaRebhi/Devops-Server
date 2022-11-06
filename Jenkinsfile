pipeline{
agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }

        stages{


                 stage('Build Maven Spring'){
                             steps{
                                sh 'mvn  clean install '
                             }
                         }

			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t oumaymafarhani/springprojet .'
                                 }
                             }
                         }


                stage('Testing process') {
                              steps {
                               script {
                                sh 'echo "Test is processing ...."'
                                sh 'mvn clean test'
                               }
                              }
                            }

             stage('MVN SONARQUBE ')
                                {
                          steps{
                    sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  '
                                     }
                                               }
		stage("Maven Build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
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
                     	sh 'docker push oumaymafarhani/springprojet'
                        }  }
         stage('Docker compose') {

                          steps {
                               sh 'docker-compose up -d'
                                 }  }

        }

      }
