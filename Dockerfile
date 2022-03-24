FROM ubuntu

# Set time zone Moscow
ENV TZ=Africa/Johannesburg
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Create and add SDK ROOT
RUN mkdir -p /root/Android/Sdk
ENV ANDROID_SDK_ROOT=/root/Android/Sdk

# Install all dependencies.
RUN apt update && apt install -y openjdk-8-jdk vim git unzip libglu1 libpulse-dev libasound2 libc6 \
libstdc++6 libx11-6 libx11-xcb1 libxcb1 libxcomposite1 libxcursor1 libxi6  libxtst6 libnss3 \
wget curl mc

# Install sdk tools
RUN wget 'https://dl.google.com/android/repository/platform-tools-latest-linux.zip' -P /tmp \
&& unzip -d ${ANDROID_SDK_ROOT} /tmp/platform-tools-latest-linux.zip

# Accept the license agreements of the SDK components
ADD license_accepter.sh ${ANDROID_SDK_ROOT}

RUN chmod +x license_accepter.sh && ${ANDROID_SDK_ROOT}/license_accepter.sh ${ANDROID_SDK_ROOT}

# Intsall Gradle and Add all ENV
ENV GRADLE_HOME=/opt/gradle/gradle-$GRADLE_VERSION

ENV PATH "$PATH:$GRADLE_HOME/bin:/opt/gradlew:$ANDROID_HOME/emulator:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools"

ENV LD_LIBRARY_PATH "$ANDROID_HOME/emulator/lib64:$ANDROID_HOME/emulator/lib64/qt/lib"

WORKDIR /

SHELL ["/bin/bash", "-c"]

ADD create-emulator.sh /

RUN chmod +x create-emulator.sh