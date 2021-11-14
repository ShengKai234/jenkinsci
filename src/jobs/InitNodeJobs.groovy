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
            echo \$password | sudo -S apt-get update

            echo Install curl ...
            echo \$password | sudo -S apt-get install -y curl

            echo Install docker ...
            echo \$password | sudo -S apt-get install -y docker-ce docker-ce-cli containerd.io
            # echo \$password | sudo -S apt-get install -y docker-ce=<VERSION_STRING> docker-ce-cli=<VERSION_STRING> containerd.io
            # echo \$password | sudo -S apt-get install -y docker.io
            # echo \$password | sudo -S curl -fsSL https://get.docker.com/ | sh || trap 2
            echo \$password | sudo -S docker --version
            
            echo Install docker-compose ...
            echo \$password | sudo -S curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-\$(uname -s)-\$(uname -m)" -o /usr/local/bin/docker-compose || true
            echo \$password | sudo -S chmod +x /usr/local/bin/docker-compose
            echo \$password | sudo -S docker-compose -–version

            # echo Install docker maven
            # echo \$password | sudo -S docker run -ti --name maven  maven:latest bash
        """)
    }
}