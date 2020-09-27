Heroku CLI
//Works on git-bash

heroku login

heroku plugins:install heroku-cli-deploy

heroku war:deploy ForecastMaven/target/ForecastMaven-1.0.war --app asd-group3
