

IMAGE_REPO=ruko/jenkinsci
IMAGE_VERSION=2.288-2021.0611

build:
	docker build -t $(IMAGE_REPO):$(IMAGE_VERSION) .

deploy: build
	docker run -d --rm -uroot --name jenkinsci -it \
	-e JAVA_OPTS="-Djenkins.install.runSetupWizard=false \
	-Dhudson.security.csrf.GlobalCrumbIssuerConfiguration=false \
	-Duser.timezone=Asia/Taipei" \
	-w /code \
	-v $$PWD:/code \
	-v $(PWD)/jenkins_data:/var/jenkins_home \
	-p 8080:8080 $(IMAGE_REPO):$(IMAGE_VERSION) bash /code/docker-entrypoint.sh
	chmod -R 777 jenkins_data


git/push:
	git add .
	git commit -m "test"
	git push