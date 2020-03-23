@echo off
pushd %~dp0
setlocal ENABLEDELAYEDEXPANSION

rem MyBatis Generator のjar名
set "jar_name=mybatis-generator-core-1.3.5.jar"

rem 設定ファイル名
set "config_name=generatorConfig_nhlng.xml"

rem 実行
java -jar ".\%jar_name%" -configfile %config_name% -overwrite

endlocal
popd

pause
exit
