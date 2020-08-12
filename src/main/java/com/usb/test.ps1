clear
gdr -PSProvider 'FileSystem'

Write-Host "$([Environment]::NewLine)"
$Drive = Read-Host -Prompt 'Enter Name of drive( eg. C, D, E ...)'

Write-Host "$Drive"

javac App.java 

java App "$Drive"
