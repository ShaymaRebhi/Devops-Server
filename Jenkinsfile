pipeline{
agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }

        stages{




 stage('MOCK/JUNIT') {
                              steps {
                               script {
                                sh 'echo "Test is processing ...."'
                                sh 'mvn test'
                               }
                              }
                                post {
                                         always {
                                          junit '**/target/surefire-reports/TEST-*.xml'
                                          }
                                          }

                            }
    stage('MVN SONARQUBE ')
              {
                                                      steps{
                                                sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar  '
                                                                 }
                                                                           }

                      stage('Build'){
                                                  steps{
                                                     sh 'mvn  clean install -DskipTests '
                                                  }
                                              }

                                              stage('NEXUS')
                                                      {
                                                          steps{
                                                              echo "nexus"
                                                               sh ' mvn  deploy -DskipTests'
                                                          }
                                                      }

			    stage('Build docker image'){
                             steps{
                                 script{
                                    sh 'docker build -t shaymarebhi/springprojet .'
                                 }
                             }
                         }


		 		 stage('Docker login') {

                                         steps {
                                          sh 'echo "login Docker ...."'
                   	sh 'docker login -u shaymarebhi -p lafloufet123'
                               }  }
		 stage('Docker push') {

                 steps {
                      sh 'echo "Docker is pushing ...."'
                     	sh 'docker push shaymarebhi/springprojet'
                        }  }
         stage('Docker compose') {

                          steps {
                               sh 'docker-compose up -d'
                                 }  }


        }

      }