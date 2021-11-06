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
"vm_sysadmin_id", // id
"My local ubuntu vm id", // description
"sysadmin", // username
"kaiboy" // password
)
SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), c)

Credentials c2 = (Credentials) new UsernamePasswordCredentialsImpl(
CredentialsScope.GLOBAL, // Scope
"git_example_id", // id
"My git id", // description
"xxxxxx", // username
"xxxxxx" // password
)
SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), c)