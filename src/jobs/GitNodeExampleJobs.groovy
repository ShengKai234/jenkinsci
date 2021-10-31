job('git.node.job.example') {
    description("This is example job!")
    label('example')
    logRotator {
        numToKeep 20
    }
    scm {
        git {
            remote {
                github('shengkai234/springboot')
                refspec('+refs/heads/*:refs/remotes/origin/*')
                credentials("git_example_id")
            }
            branch('*/develop')
        }
    }
    wrappers {
        //timestamps()
        credentialsBinding { 
            usernamePassword('username', 'password', 'vm_sysadmin_id')
        } 
    }
    steps {
        shell("""
            echo \$password | sudo -S docker start maven
            WORKPATH="/home/sysadmin/jenkins/data/workspace/sivas.dev.v.2.0"
            CONTAINER_NAME="sivas"
            IMAGE_TAG=\$(echo \$GIT_COMMIT | cut -c1-7)
            PROJECT="vans-web"
            WAR_NAME=SIVAS.war

            cd \$WORKPATH
            echo \$password | sudo -S docker exec maven bash -c "cd \$WORKPATH/\$PROJECT && mvn clean package -Dprofile.active=test -Dmaven.test.skip=true"

            cd \$WORKPATH
            echo \$password | sudo -S cp \$WORKPATH/\$PROJECT/target/\$WAR_NAME \$WORKPATH

            echo \$password | sudo -S docker stop \$CONTAINER_NAME || true
            echo \$password | sudo -S docker rm \$CONTAINER_NAME || true
            echo \$password | sudo -S docker image rm \$CONTAINER_NAME:\$IMAGE_TAG || true

            echo \$password | sudo -S docker build -f \$PROJECT/"Dockerfile" --build-arg WAR_FILE=\$WAR_NAME  -t \$CONTAINER_NAME:\$IMAGE_TAG .
            echo \$password | sudo -S docker tag \$CONTAINER_NAME:\$IMAGE_TAG \$CONTAINER_NAME:latest


            cd \$WORKPATH/\$PROJECT
            echo \$password | sudo -S docker-compose up -d

            echo \$password | sudo -S docker exec maven bash -c "rm -rf \$WORKPATH/\$PROJECT"
        """)
    }
    
}