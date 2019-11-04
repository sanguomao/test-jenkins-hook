
// env.docker_image_build_version = getDockerImageBuildVersion()
// docker_image_build_version=getDockerImageBuildVersion()
a="abc"

String getShortCommitForBuild() {
	  return sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
}

String getDOCKER_IMAGE_BUILD_VERSION() {
    def comm = getShortCommitForBuild()
		println(comm)
    return "build-${env.BUILD_NUMBER}-${comm}"
}

String getA() {
	return "def"
}

def info(message) {
    echo "INFO: ${message}"
		println(a)
		// def docker_image_build_version="abc"
		// println(env.docker_image_build_version)
		println(DOCKER_IMAGE_BUILD_VERSION)
		sh """#!/bin/bash
		echo ${DOCKER_IMAGE_BUILD_VERSION}
		"""
}

def warning(message) {
    warn = sh(
        returnStdout: true,
        script: "git remote show origin -n |  grep h.URL | sed 's/.*://;s/.git//' ",
    ).trim()
		println(warn)
}

String getRepoName() {
		def repoUrl = sh(returnStdout: true, script: 'git config remote.origin.url').trim()
		def repoName = repoUrl.tokenize('/')[-1].tokenize('.')[0]
		script {
			env.TEMP_LOG = """${sh(
					returnStdout: true,
					script: 'mktemp',
			)}
			"""
    }
		println(env.TEMP_LOG)
		println(params.PROD_VERSION)
		println(repoName)
		return repoName
}
