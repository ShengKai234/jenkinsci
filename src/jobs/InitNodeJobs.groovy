job('init.node.job.example') {
    description("This is example job!")
    label('example')
    logRotator {
        numToKeep 20
    }
    wrappers {
        //timestamps()
        credentialsBinding { 
            usernamePassword('username', 'password', 'vm_sysadmin_id')
        } 
    }
    steps {
        shell("""
            echo Update apt-get
            echo \$password | sudo apt-get update

            echo Install curl ...
            echo \$password | sudo apt-get install -y curl

            echo Install docker ...
            echo \$password | sudo -y curl -fsSL https://get.docker.com/ | sh
            echo \$password | sudo docker --version
            
            echo Install docker-compose ...
            echo \$password | sudo -y curl -L "https://github.com/docker/compose/releases/download/1.28.5/docker-compose-\$(uname -s)-\$(uname -m)" -o /usr/local/bin/docker-compose
            echo \$password | sudo chmod +x /usr/local/bin/docker-compose
            echo \$password | docker-compose –version
        """)
    }
    
}