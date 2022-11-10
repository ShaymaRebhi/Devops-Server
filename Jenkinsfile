pipeline{
agent any
   stages{
        stage('MOCK/JUNIT test') {
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

                              stage('Build Maven Project'){
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

stage('Sending email'){
	    steps {
	        mail bcc: '', body: '''Salut oumayma farhani,
	        Devops Pipeline Back se lance avec success.
	        ''', cc: '', from: '', replyTo: '', subject: 'Devops', to: 'oumayma.farhani@esprit.tn'
	             }
	        }
                }


      }
