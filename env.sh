# Check OS type
if [ "${OSTYPE//[0-9.]/}" == "darwin" ]; then
  export ANDROID_HOME="${HOME}/Library/Android/sdk"
  export PATH=${ANDROID_HOME}/emulator:${ANDROID_HOME}/tools:$PATH

elif [ "${OSTYPE//[0-9.]/}" == "linux-gnu" ]; then
  export ANDROID_HOME="${HOME}/Android/Sdk"
  export PATH=${ANDROID_HOME}/emulator:${ANDROID_HOME}/tools:$PATH

elif [ "${OSTYPE//[0-9.]/}" == "win32" ]; then
  export ANDROID_HOME="${HOME}/Android/Sdk"

else
  printf "I don't know OS Type"
fi