import jenkins.model.*
import hudson.model.*
import hudson.slaves.*
import hudson.plugins.sshslaves.*
import java.util.ArrayList;
import hudson.slaves.EnvironmentVariablesNodeProperty.Entry;
import hudson.plugins.sshslaves.verifiers.NonVerifyingKeyVerificationStrategy;

  List<Entry> env = new ArrayList<Entry>();
  env.add(new Entry("key1","value1"))
  env.add(new Entry("key2","value2"))
  EnvironmentVariablesNodeProperty envPro = new EnvironmentVariablesNodeProperty(env);
  Slave slave = new DumbSlave(
                    "my-ubuntu-node",
                    "This Node with SSH",
                    "/home/kai/data",
                    "1",
                    Node.Mode.NORMAL,
                    "my-centos", // label
                    new SSHLauncher(
                            "172.16.21.3",
                            22,
                            "my_ubuntu_id",
                            "",   // jvmOptions
                            null, // javaPath
                            null, // prefixStartSlaveCmd
                            "",   // suffixStartSlaveCmd
                            60,
                            3,
                            15,
                            new NonVerifyingKeyVerificationStrategy()
                    ),
                    new RetentionStrategy.Always()
                    )
  slave.getNodeProperties().add(envPro)
  Jenkins.instance.addNode(slave)