environment{

}

pipeline {
    agent any 

    stages {

        stage("Git") {
            steps {
                git url:  'echo "https://github.com/lucasko/gradle-task-example.git"'
            }
        }

        stage('Build') {
            steps{
                sh 'echo "./gradlew build --profile --no-daemon -s"'
            }
        }

        stage('Test') {
            steps{
                sh 'echo "./gradlew  test"'
            }
        }

    }//end of stages
}


 
