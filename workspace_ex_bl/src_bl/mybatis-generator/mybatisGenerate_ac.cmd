@echo off
pushd %~dp0
setlocal ENABLEDELAYEDEXPANSION

rem MyBatis Generator ��jar��
set "jar_name=mybatis-generator-core-1.3.5.jar"

rem �ݒ�t�@�C����
set "config_name=generatorConfig_nhlng.xml"

rem ���s
java -jar ".\%jar_name%" -configfile %config_name% -overwrite

endlocal
popd

pause
exit
