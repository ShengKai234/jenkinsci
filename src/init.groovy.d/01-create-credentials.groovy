import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;
import org.jenkinsci.plugins.plaincredentials.*
import org.jenkinsci.plugins.plaincredentials.impl.*
import com.cloudbees.plugins.credentials.common.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import hudson.util.Secret

Credentials c = (Credentials) new UsernamePasswordCredentialsImpl(
CredentialsScope.GLOBAL, // Scope
"my_ubuntu_id", // id
"My description ubuntu id", // description
"kai", // username
"kaiboy" // password
)

SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), c)

