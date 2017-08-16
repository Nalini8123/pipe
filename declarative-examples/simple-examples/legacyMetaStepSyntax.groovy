pipeline {
  agent any

  stages {
    stage("foo") {
      steps {
        writeFile text: 'hello world', file: 'msg.out'
        /*
         * Some steps may not be fully implemented with symbols or step names to run directly
         * This syntax can be used to call the class directly and run that step.
         * This syntax works fine in Declarative
         */
        step([$class: 'ArtifactArchiver', artifacts: 'msg.out', fingerprint: true])
        sh('echo ONSLAVE=$ONSLAVE')
      }
    }
  }
}
