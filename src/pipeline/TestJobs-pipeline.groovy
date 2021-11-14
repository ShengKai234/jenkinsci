environment{

}

pipeline {
    agent { label 'example' }
    stages {
        stage("Git-Checkout") {
            steps {
                echo "Checking out from Git Repo";
                sh 'echo "Checking out from Git Repo by sh"'
            }
        }

        stage('Build') {
            steps{
                
                withCredentials([usernamePassword(credentialsId: 'vm_sysadmin_id', passwordVariable: 'password', usernameVariable: 'username')]) {
                    // some block
                    sh '''
                        echo "Building the checked-out project by docker!";
                        docker -v;
                        echo $password | sudo -S docker-compose -–version;
                    '''
                }
            }
        }

        stage('Unit-Test') {
            steps{
                echo "Running JUnit Tests";
            }
        }
        
        stage('Quality-Gate') {
            steps{
                echo "SonarQube Quality Gate passed successfully!!";
                /*sh exit ("1");*/
            }
        }
        
        stage('Deploy') {
            steps{
                echo "Pass!";
            }
        }

    }//end of stages
    post {
        always {
            echo 'This is always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipline has changed'
            echo 'For example, if the Pipline was previously failing but is now successful'
        }
    }
}


 
