# Build jar
FROM maven:3-openjdk-17-slim AS builder

ARG BUILD_ENV
ENV BUILD_ENV $BUILD_ENV

WORKDIR build

ADD . /build

RUN chmod +x ./scripts/build.sh && ./scripts/build.sh


# Package jar
FROM openjdk:17-oracle

WORKDIR /home

# Copy jar from builder
COPY --from=builder /build/target/app.jar /home

ADD scripts/entrypoint.sh /
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
