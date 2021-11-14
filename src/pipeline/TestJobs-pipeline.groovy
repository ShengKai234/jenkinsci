environment{

}

pipeline {
    agent { label 'example' }
    stages {
        stage("Git-Checkout") {
            steps {
                echo "Checking out from Git Repo";
            }
        }

        stage('Build') {
            steps{
                echo "Building the checked-out project!";
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


 
