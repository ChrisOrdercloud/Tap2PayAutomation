#!/bin/bash

ANDROID_API_LEVEL=29
ANDROID_BUILD_TOOLS_LEVEL=29.0.3
EMULATOR="${ANDROID_HOME}/emulator/emulator"
IS_VISIBLE="-no-window"

# This function remove emulator if exists.
#function removeAllExistsEmulator() {
#  ${ADB} devices | grep emulator | cut -f1 | while read line; do ${ADB} -s $line emu kill; done
#}

# This function run emulator with default settings.
function wait_emulator_to_be_ready() {
  ${ANDROID_HOME}/tools/bin/sdkmanager --install "platform-tools" "system-images;android-${ANDROID_API_LEVEL};default;x86" "platforms;android-${ANDROID_API_LEVEL}" "build-tools;${ANDROID_BUILD_TOOLS_LEVEL}" "emulator" &&
    yes Y | ${ANDROID_HOME}/tools/bin/sdkmanager --licenses &&
    echo "no" | ${ANDROID_HOME}/tools/bin/avdmanager --verbose create avd --force --name "test" --device "pixel" --package "system-images;android-${ANDROID_API_LEVEL};default;x86" --tag "default" --abi "x86"
  ${ADB} devices | grep ${EMULATOR} | cut -f1 | while read line; do ${ADB} -s $line emu kill; done
  ${EMULATOR} -avd test -memory 4096 $IS_VISIBLE -no-audio -gpu off -no-boot-anim -accel on -skin 1180x2220 &
  boot_completed=false
  while [ "$boot_completed" == false ]; do
    status=$(${ADB} wait-for-device shell getprop sys.boot_completed | tr -d '\r')
    echo "Boot Status: $status"
    if [ "$status" == "1" ]; then
      boot_completed=true
    else
      sleep 1
    fi
  done
}