DESCRIPTION = "NXP Hovergames license install"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://EULA.txt \
    file://HoverGamesLicense.txt \ 
    file://SCR.txt \
"

S = "${WORKDIR}"

inherit useradd
USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system navq"
USERADD_PARAM_${PN} = "--system -U navq"

do_install() {
    install -d ${D}/home/navq
    install -m 0644 ${S}/EULA.txt ${D}/home/navq/
    install -m 0644 ${S}/HoverGamesLicense.txt ${D}/home/navq/
    install -m 0644 ${S}/SCR.txt ${D}/home/navq/
    chown -R navq:navq ${D}/home/navq
}

FILES_${PN} = "/home/navq"
