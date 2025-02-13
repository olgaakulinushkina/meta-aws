# -*- mode: Conf; -*-
SUMMARY = "AWS C Cal"
DESCRIPTION = "AWS Crypto Abstraction Layer: Cross-Platform, C99 wrapper for cryptography primitives."

HOMEPAGE = "https://github.com/awslabs/aws-c-cal"
LICENSE = "Apache-2.0"
PROVIDES += "aws/crt-c-cal"

inherit cmake

LIC_FILES_CHKSUM = "file://LICENSE;md5=34400b68072d710fecd0a2940a0d1658"

BRANCH ?= "main"

SRC_URI = "git://github.com/awslabs/aws-c-cal.git;protocol=https;branch=${BRANCH};"

SRCREV = "ac4216b78d5323b5b8ce95a3dd4a8fc0f95e2d33"


S = "${WORKDIR}/git"

DEPENDS = "openssl s2n aws-c-common"
RDEPENDS:${PN} = "s2n aws-c-common"

CFLAGS:append = " -Wl,-Bsymbolic"
EXTRA_OECMAKE += " \
    -DBUILD_SHARED_LIBS=ON \
    -DCMAKE_MODULE_PATH=${STAGING_LIBDIR}/cmake \
    -DCMAKE_PREFIX_PATH=$D/usr \
    -DCMAKE_INSTALL_PREFIX=$D/usr \
    -DCMAKE_BUILD_TYPE=Release \
"

FILES:${PN}-dev += "${libdir}/*/cmake"

BBCLASSEXTEND = "native nativesdk"

