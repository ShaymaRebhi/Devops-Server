pipeline{
agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }

   stages{
        stage('MOCK') {
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
                                            sh 'docker build -t oumaymafarhani/springprojet .'
                                                 }
                                         }
                                    }



        stage('Docker login') {

                                   steps {
                                    sh 'echo "login Docker ...."'
                                    sh 'docker login -u oumaymafarhani -p 29416927Oumayma'
                                       }
                                }
         stage('Docker push') {
                               steps {
                                  sh 'echo "Docker is pushing ...."'
                                sh 'docker push oumaymafarhani/springprojet'
                                }
                               }
        stage('Docker compose') {
                                steps {
                                  sh 'docker-compose up -d'
                                       }
                                   }


                }
              stage('Sending email'){
              	    steps {
              	        mail bcc: '', body: '''Hello from oumayma farhani,
              	        Devops Pipeline with success.
              	        Cordialement''', cc: '', from: '', replyTo: '', subject: 'Devops', to: 'hiba.elwafi@esprit.tn'
              	             }
              	        }

      }
