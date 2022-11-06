pipeline{
agent any


        stages{




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

                      stage('Build Maven Spring'){
                                                  steps{
                                                     sh 'mvn  clean install '
                                                  }
                                              }

                                              stage('NEXUS')
                                                      {
                                                          steps{
                                                              echo "nexus"
                                                               sh ' mvn clean deploy -DskipTests'
                                                          }
                                                      }

			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t hibaef/springprojet .'
                                 }
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
                   	sh 'docker login -u hibaef -p 13632307Hiba'
                               }  }
		 stage('Docker push') {

                 steps {
                      sh 'echo "Docker is pushing ...."'
                     	sh 'docker push hibaef/springprojet'
                        }  }
         stage('Docker compose') {

                          steps {
                               sh 'docker-compose up -d'
                                 }  }

        }

      }