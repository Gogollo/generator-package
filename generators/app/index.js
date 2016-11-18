'use strict';
var yeoman = require('yeoman-generator');
var chalk = require('chalk');
var yosay = require('yosay');
var mkdirp = require('mkdirp');

module.exports = yeoman.Base.extend({
  prompting: function () {

    var prompts = [
      {
      type: 'input',
      name: 'packageName',
      message: 'Package name: '
    },
      {
        type: 'input',
        name: 'fileNames',
        message: 'File names: '
      }
    ];

    return this.prompt(prompts).then(function (props) {
      this.props = props;
    }.bind(this));
  },

  writing: function () {
    function normalizeFirstLetter(string) {
      return string.charAt(0).toLowerCase() + string.substring(1);
    }

    var pName = this.props.packageName;
    var pathAPI = pName + "/api";
    var pathDTO = pName + "/dto";
    var pathOB = pName + "/ob";
    var pathConv = pName + "/converters";
    var pathRepo = pName + "/repository";
    var pathServ = pName + "/service";
    var pathServImpl = pathServ + "/impl";

    var nameForClasses = this.props.fileNames;
    var nameAPI = nameForClasses + "RestController";
    var nameDTO = nameForClasses + "DTO";
    var nameOB = nameForClasses + "OB";
    var nameConv = nameForClasses + "Converters";
    var nameRepo = nameForClasses + "Repository";
    var nameServ = "I" + nameForClasses + "Service";
    var nameServImpl = nameForClasses + "ServiceImpl";
	var nameServFirstLower = normalizeFirstLetter(nameServ.substring(1));
	var nameRepoFirstLower = normalizeFirstLetter(nameRepo);
	var nameConvFirstLower = normalizeFirstLetter(nameConv);

    mkdirp(pathAPI);
    mkdirp(pathDTO);
    mkdirp(pathOB);
    mkdirp(pathConv);
    mkdirp(pathRepo);
    mkdirp(pathServ);
    mkdirp(pathServImpl);

    this.fs.copyTpl(
      this.templatePath('DTO.java'),
      this.destinationPath(pathDTO + "/" + nameDTO + ".java"),
      {
        packageName: this.props.packageName,
        name: nameDTO
      }
    );

    this.fs.copyTpl(
      this.templatePath('OB.java'),
      this.destinationPath(pathOB + "/" + nameOB + ".java"),
      {
        packageName: this.props.packageName,
        name: nameOB
      }
    );

    this.fs.copyTpl(
      this.templatePath('Converters.java'),
      this.destinationPath(pathConv + "/" + nameConv + ".java"),
      {
        packageName: this.props.packageName,
        name: nameConv,
		nameOB: nameOB,
		nameDTO: nameDTO
      }
    );

    this.fs.copyTpl(
      this.templatePath('Repository.java'),
      this.destinationPath(pathRepo + "/" + nameRepo + ".java"),
      {
        packageName: this.props.packageName,
        name: nameRepo,
        nameOB: nameOB
      }
    );

    this.fs.copyTpl(
      this.templatePath('Service.java'),
      this.destinationPath(pathServ + "/" + nameServ + ".java"),
      {
        packageName: this.props.packageName,
        name: nameServ,
		nameDTO: nameDTO,
		
      }
    );

    this.fs.copyTpl(
      this.templatePath('ServiceImpl.java'),
      this.destinationPath(pathServImpl + "/" + nameServImpl + ".java"),
      {
        packageName: this.props.packageName,
        name: nameServImpl,
        nameServ: nameServ,
		nameDTO: nameDTO,
		nameConv: nameConv,
		nameRepo: nameRepo,
		nameRepoFirstLower: nameRepoFirstLower,
		nameConvFirstLower: nameConvFirstLower
      }
    );

    this.fs.copyTpl(
      this.templatePath('RestController.java'),
      this.destinationPath(pathAPI + "/" + nameAPI + ".java"),
      {
        packageName: this.props.packageName,
        name: nameAPI,
		nameServ: nameServ,
		nameDTO: nameDTO,
		nameOB: nameOB,
		nameServFirstLower: nameServFirstLower
      }
    );


  }
});
