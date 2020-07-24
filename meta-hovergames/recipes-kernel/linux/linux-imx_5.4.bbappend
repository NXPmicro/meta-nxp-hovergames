FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://containers.cfg \
    file://0001-Add-NavQ-device-trees.patch \
    file://0002-ARM64-dts-imx8mmnavq-Change-SD2_CD-pin-for-SDHC2.patch \
    file://0003-Add-OV5645-driver.patch \
    file://0004-ARM64-dts-Add-OV5645-support-for-imx8mm-navq-board.patch \
    file://0005-OV5645-Disable-auto-focus-on-initialization.patch \
    file://0006-OV5645-Disable-regulators-if-camera-is-not-found.patch \
    file://0007-dts-bug-fix.patch \
    file://0008-imx-sdma-firmware-load-hotfix.patch \
"

do_configure_append () {
    ${S}/scripts/kconfig/merge_config.sh -m -O ${WORKDIR}/build ${WORKDIR}/build/.config ${WORKDIR}/*.cfg
}
