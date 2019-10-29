
DOCKER_IMAGE_BUILD_VERSION = "build-${env.BUILD_NUMBER}-${GIT_SHORT_COMMIT}"

def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
		println(this.env.DOCKER_DEV_REGISTRY)
}

String getRepoName() {
	// def repoUrl = sh(returnStdout: true, script: 'git config remote.origin.url').trim()
	// def repoName = repoUrl.tokenize('/')[-1].tokenize('.')[0]
	// return repoName
	repoName = sh(
			returnStdout: true,
			script: "git remote show origin -n |  grep h.URL | sed 's/.*://;s/.git//' ",
	).trim()
	println(repoName)
}

String getShortCommitForBuild() {
	def GIT_SHORT_COMMIT = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
	return GIT_SHORT_COMMIT
}

String getDockerImageBuildVersion() {
	def GIT_SHORT_COMMIT = getShortCommitForBuild()
	return "build-${env.BUILD_NUMBER}-${GIT_SHORT_COMMIT}"
}

// def sendDingTalk(status, message) {
//     if (status == "success") {
//         img="https://s2.ax1x.com/2019/10/17/KEFSWd.png"
//     } else if (status == "failure") {
//         img="https://s2.ax1x.com/2019/10/17/KEFCQI.png"
//     } else if (status == "pending") {
//         img="https://s2.ax1x.com/2019/10/17/KEFkef.gif"
//     } else {
//         img=""
//     }
//     dingTalk([
//         accessToken: "${env.DING_TALK_ENTRYPOINT}",
//         jenkinsUrl: "${env.JENKINS_URL}",
//         imageUrl: img,
//         message: message,
//     ])
// }

def call(String buildType) {
	if (buildType == 'build') {
		pipeline {
			agent any

			environment {
					DOCKER_DEV_REGISTRY="https://harbor.longguikeji.com"
			}

			stages {
					stage('Build') {
							steps {
									script {
											info 'hello'
											warning 'world'
									}
							}
					}
			}

			post {
					success {
							script {
									sendDingTalk("success", "构建成功")
							}
					}
					failure {
							script {
									sendDingTalk("failure", "构建失败")
							}
					}
			}
		}
	} else if(buildType == 'status') {
		pipeline {
			agent any

			environment {
					DOCKER_DEV_REGISTRY="https://status.longguikeji.com"
			}

			stages {
					stage('status') {
							steps {
									script {
											info 'hello'
											warning 'world'
									}
							}
					}
			}

			post {
					success {
							script {
									sendDingTalk("success", "status构建成功")
							}
					}
					failure {
							script {
									sendDingTalk("failure", "status构建失败")
							}
					}
			}
		}

	} else {
		pipeline {
			agent any

			environment {
					DOCKER_DEV_REGISTRY="https://release.longguikeji.com"
			}

			stages {
					stage('release') {
							steps {
									script {
											info 'hello'
											warning 'world'
									}
							}
					}
			}

			post {
					success {
							script {
									sendDingTalk("success", "release构建成功")
							}
					}
					failure {
							script {
									sendDingTalk("failure", "release构建失败")
							}
					}
			}
		}
	}
}

def sendDingTalk(status, message) {
	if (status == "success") {
			img="https://s2.ax1x.com/2019/10/17/KEFSWd.png"
	} else if (status == "failure") {
			img="https://s2.ax1x.com/2019/10/17/KEFCQI.png"
	} else if (status == "pending") {
			img="https://s2.ax1x.com/2019/10/17/KEFkef.gif"
	} else {
			img=""
	}
	dingTalk([
			accessToken: "${env.DING_TALK_ENTRYPOINT}",
			jenkinsUrl: "${env.JENKINS_URL}",
			imageUrl: img,
			message: message,
	])
}